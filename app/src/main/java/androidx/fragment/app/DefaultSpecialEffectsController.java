package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            SpecialEffectsController.Operation.State.values();
            int[] iArr = new int[4];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = animationOrAnimatorLoadAnimation;
            this.mLoadedAnim = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    public static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return stateFrom == finalState || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList<AnimationInfo> arrayList = new ArrayList();
        boolean z2 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                String str = "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.";
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            final boolean z3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(operation);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z3) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        for (final AnimationInfo animationInfo2 : arrayList) {
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    String str2 = "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.";
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    String str3 = "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.";
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, final boolean z, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        Object obj;
        View view;
        Object obj2;
        ArrayList arrayList;
        Rect rect;
        HashMap map;
        SpecialEffectsController.Operation operation3;
        Object obj3;
        final ArrayList<View> arrayList2;
        View view2;
        ArrayList arrayList3;
        Rect rect2;
        View view3;
        HashMap map2;
        Object objMergeTransitionsTogether;
        View view4;
        ArrayMap arrayMap;
        ArrayList<View> arrayList4;
        ArrayList<View> arrayList5;
        FragmentTransitionImpl fragmentTransitionImpl;
        HashMap map3;
        Rect rect3;
        View view5;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList6;
        final View view6;
        String strFindKeyForValue;
        ArrayList<String> arrayList7;
        boolean z2 = z;
        HashMap map4 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    StringBuilder sbR = a.r("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    sbR.append(transitionInfo.getOperation().getFragment());
                    sbR.append(" returned Transition ");
                    sbR.append(transitionInfo.getTransition());
                    sbR.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(sbR.toString());
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                map4.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return map4;
        }
        View view7 = new View(getContainer().getContext());
        final Rect rect4 = new Rect();
        ArrayList<View> arrayList8 = new ArrayList<>();
        ArrayList<View> arrayList9 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Object obj4 = null;
        SpecialEffectsController.Operation operation4 = operation2;
        View view8 = null;
        boolean z3 = false;
        SpecialEffectsController.Operation operation5 = operation;
        for (TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.hasSharedElementTransition() || operation5 == null || operation4 == null) {
                view4 = view8;
                arrayMap = arrayMap2;
                arrayList4 = arrayList9;
                arrayList5 = arrayList8;
                fragmentTransitionImpl = fragmentTransitionImpl2;
            } else {
                Object objWrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList10 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList10;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z2) {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                int i3 = 0;
                while (i3 < size) {
                    arrayMap2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                    size = size;
                    view8 = view8;
                }
                view4 = view8;
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view9 = arrayMap3.get(str);
                        if (view9 == null) {
                            arrayMap2.remove(str);
                            arrayList7 = sharedElementSourceNames;
                        } else {
                            arrayList7 = sharedElementSourceNames;
                            if (!str.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList7;
                    }
                    arrayList6 = sharedElementSourceNames;
                } else {
                    arrayList6 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                final ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view10 = arrayMap4.get(str2);
                        if (view10 == null) {
                            String strFindKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str2);
                            if (strFindKeyForValue2 != null) {
                                arrayMap2.remove(strFindKeyForValue2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view10)) && (strFindKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                            arrayMap2.put(strFindKeyForValue, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList8.clear();
                    arrayList9.clear();
                    obj4 = null;
                    operation5 = operation;
                    operation4 = operation2;
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList9;
                    arrayList5 = arrayList8;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                    ArrayList<String> arrayList11 = arrayList6;
                    ArrayMap arrayMap5 = arrayMap2;
                    HashMap map5 = map4;
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap4, false);
                        }
                    });
                    Iterator<View> it = arrayMap3.values().iterator();
                    while (it.hasNext()) {
                        captureTransitioningViews(arrayList8, it.next());
                    }
                    if (!arrayList11.isEmpty()) {
                        View view11 = arrayMap3.get(arrayList11.get(0));
                        fragmentTransitionImpl2.setEpicenter(objWrapTransitionInSet, view11);
                        view4 = view11;
                    }
                    Iterator<View> it2 = arrayMap4.values().iterator();
                    while (it2.hasNext()) {
                        captureTransitioningViews(arrayList9, it2.next());
                    }
                    if (!sharedElementTargetNames2.isEmpty() && (view6 = arrayMap4.get(sharedElementTargetNames2.get(0))) != null) {
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view6, rect4);
                            }
                        });
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(objWrapTransitionInSet, view7, arrayList8);
                    arrayMap = arrayMap5;
                    arrayList4 = arrayList9;
                    arrayList5 = arrayList8;
                    View view12 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    map3 = map5;
                    map3.put(operation, bool);
                    map3.put(operation2, bool);
                    rect3 = rect4;
                    obj4 = objWrapTransitionInSet;
                    operation4 = operation2;
                    view5 = view12;
                    operation5 = operation;
                    arrayMap2 = arrayMap;
                    arrayList9 = arrayList4;
                    arrayList8 = arrayList5;
                    rect4 = rect3;
                    view8 = view4;
                    z2 = z;
                    view7 = view5;
                    map4 = map3;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                }
            }
            map3 = map4;
            view5 = view7;
            rect3 = rect4;
            arrayMap2 = arrayMap;
            arrayList9 = arrayList4;
            arrayList8 = arrayList5;
            rect4 = rect3;
            view8 = view4;
            z2 = z;
            view7 = view5;
            map4 = map3;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
        }
        View view13 = view8;
        ArrayMap arrayMap6 = arrayMap2;
        ArrayList<View> arrayList12 = arrayList9;
        ArrayList<View> arrayList13 = arrayList8;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        HashMap map6 = map4;
        View view14 = view7;
        Rect rect5 = rect4;
        ArrayList arrayList14 = new ArrayList();
        Object objMergeTransitionsTogether2 = null;
        Object obj5 = null;
        for (TransitionInfo transitionInfo4 : list) {
            if (transitionInfo4.isVisibilityUnchanged()) {
                map6.put(transitionInfo4.getOperation(), Boolean.FALSE);
                transitionInfo4.completeSpecialEffect();
            } else {
                Object objCloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo4.getTransition());
                SpecialEffectsController.Operation operation6 = transitionInfo4.getOperation();
                boolean z4 = obj4 != null && (operation6 == operation5 || operation6 == operation4);
                if (objCloneTransition == null) {
                    if (!z4) {
                        map6.put(operation6, Boolean.FALSE);
                        transitionInfo4.completeSpecialEffect();
                    }
                    view3 = view14;
                    objMergeTransitionsTogether = obj5;
                    rect2 = rect5;
                    map2 = map6;
                    arrayList3 = arrayList14;
                    view2 = view13;
                } else {
                    HashMap map7 = map6;
                    ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj6 = obj5;
                    captureTransitioningViews(arrayList15, operation6.getFragment().mView);
                    if (z4) {
                        if (operation6 == operation5) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(objCloneTransition, view14);
                        obj = obj6;
                        obj2 = objMergeTransitionsTogether2;
                        arrayList = arrayList14;
                        rect = rect5;
                        arrayList2 = arrayList15;
                        view = view13;
                        map = map7;
                        obj3 = objCloneTransition;
                        operation3 = operation6;
                    } else {
                        fragmentTransitionImpl3.addTargets(objCloneTransition, arrayList15);
                        obj = obj6;
                        view = view13;
                        obj2 = objMergeTransitionsTogether2;
                        arrayList = arrayList14;
                        rect = rect5;
                        map = map7;
                        fragmentTransitionImpl3.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList15, null, null, null, null);
                        if (operation6.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = operation6;
                            list2.remove(operation3);
                            obj3 = objCloneTransition;
                            arrayList2 = arrayList15;
                            fragmentTransitionImpl3.scheduleHideFragmentView(obj3, operation3.getFragment().mView, arrayList2);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList2, 4);
                                }
                            });
                        } else {
                            operation3 = operation6;
                            obj3 = objCloneTransition;
                            arrayList2 = arrayList15;
                        }
                    }
                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList3 = arrayList;
                        arrayList3.addAll(arrayList2);
                        rect2 = rect;
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(obj3, rect2);
                        }
                        view2 = view;
                    } else {
                        view2 = view;
                        arrayList3 = arrayList;
                        rect2 = rect;
                        fragmentTransitionImpl3.setEpicenter(obj3, view2);
                    }
                    view3 = view14;
                    map2 = map;
                    map2.put(operation3, Boolean.TRUE);
                    if (transitionInfo4.isOverlapAllowed()) {
                        objMergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(obj, obj3, null);
                        objMergeTransitionsTogether2 = obj2;
                    } else {
                        objMergeTransitionsTogether2 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, obj3, null);
                        objMergeTransitionsTogether = obj;
                    }
                }
                rect5 = rect2;
                view13 = view2;
                arrayList14 = arrayList3;
                map6 = map2;
                obj5 = objMergeTransitionsTogether;
                view14 = view3;
            }
        }
        HashMap map8 = map6;
        ArrayList arrayList16 = arrayList14;
        Object objMergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj5, objMergeTransitionsTogether2, obj4);
        for (final TransitionInfo transitionInfo5 : list) {
            if (!transitionInfo5.isVisibilityUnchanged()) {
                Object transition = transitionInfo5.getTransition();
                SpecialEffectsController.Operation operation7 = transitionInfo5.getOperation();
                boolean z5 = obj4 != null && (operation7 == operation5 || operation7 == operation4);
                if (transition != null || z5) {
                    if (ViewCompat.isLaidOut(getContainer())) {
                        fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo5.getOperation().getFragment(), objMergeTransitionsInSequence, transitionInfo5.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                            @Override // java.lang.Runnable
                            public void run() {
                                transitionInfo5.completeSpecialEffect();
                            }
                        });
                    } else {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            StringBuilder sbR2 = a.r("SpecialEffectsController: Container ");
                            sbR2.append(getContainer());
                            sbR2.append(" has not been laid out. Completing operation ");
                            sbR2.append(operation7);
                            sbR2.toString();
                        }
                        transitionInfo5.completeSpecialEffect();
                    }
                }
            }
        }
        if (!ViewCompat.isLaidOut(getContainer())) {
            return map8;
        }
        FragmentTransition.setViewVisibility(arrayList16, 4);
        ArrayList<String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList12);
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList13, arrayList12, arrayListPrepareSetNameOverridesReordered, arrayMap6);
        FragmentTransition.setViewVisibility(arrayList16, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj4, arrayList13, arrayList12);
        return map8;
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void executeOperations(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r11, boolean r12) {
        /*
            r10 = this;
            java.util.Iterator r0 = r11.iterator()
            r1 = 0
            r6 = r1
            r7 = r6
        L7:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L3f
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.SpecialEffectsController$Operation r1 = (androidx.fragment.app.SpecialEffectsController.Operation) r1
            androidx.fragment.app.Fragment r3 = r1.getFragment()
            android.view.View r3 = r3.mView
            androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.from(r3)
            androidx.fragment.app.SpecialEffectsController$Operation$State r4 = r1.getFinalState()
            int r4 = r4.ordinal()
            if (r4 == 0) goto L37
            if (r4 == r2) goto L31
            r2 = 2
            if (r4 == r2) goto L37
            r2 = 3
            if (r4 == r2) goto L37
            goto L7
        L31:
            androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r3 == r2) goto L7
            r7 = r1
            goto L7
        L37:
            androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r3 != r2) goto L7
            if (r6 != 0) goto L7
            r6 = r1
            goto L7
        L3f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r11)
            java.util.Iterator r11 = r11.iterator()
        L52:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L90
            java.lang.Object r4 = r11.next()
            androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
            androidx.core.os.CancellationSignal r5 = new androidx.core.os.CancellationSignal
            r5.<init>()
            r4.markStartedSpecialEffect(r5)
            androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo r8 = new androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
            r8.<init>(r4, r5, r12)
            r0.add(r8)
            androidx.core.os.CancellationSignal r5 = new androidx.core.os.CancellationSignal
            r5.<init>()
            r4.markStartedSpecialEffect(r5)
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r8 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo
            r9 = 0
            if (r12 == 0) goto L7e
            if (r4 != r6) goto L81
            goto L80
        L7e:
            if (r4 != r7) goto L81
        L80:
            r9 = 1
        L81:
            r8.<init>(r4, r5, r12, r9)
            r3.add(r8)
            androidx.fragment.app.DefaultSpecialEffectsController$1 r5 = new androidx.fragment.app.DefaultSpecialEffectsController$1
            r5.<init>()
            r4.addCompletionListener(r5)
            goto L52
        L90:
            r2 = r10
            r4 = r1
            r5 = r12
            java.util.Map r11 = r2.startTransitions(r3, r4, r5, r6, r7)
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r12 = r11.containsValue(r12)
            r10.startAnimations(r0, r1, r12, r11)
            java.util.Iterator r11 = r1.iterator()
        La4:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Lb4
            java.lang.Object r12 = r11.next()
            androidx.fragment.app.SpecialEffectsController$Operation r12 = (androidx.fragment.app.SpecialEffectsController.Operation) r12
            r10.applyContainerChanges(r12)
            goto La4
        Lb4:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.executeOperations(java.util.List, boolean):void");
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            StringBuilder sbR = a.r("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            sbR.append(getOperation().getFragment());
            sbR.append(" returned Transition ");
            sbR.append(this.mTransition);
            sbR.append(" which uses a different Transition  type than its shared element transition ");
            sbR.append(this.mSharedElementTransition);
            throw new IllegalArgumentException(sbR.toString());
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
