package k.a.a.a.k0;

import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PredictionMode.java */
/* JADX INFO: loaded from: classes3.dex */
public enum b1 {
    SLL,
    LL,
    LL_EXACT_AMBIG_DETECTION;

    /* JADX INFO: compiled from: PredictionMode.java */
    public static final class a extends k.a.a.a.m0.a<k.a.a.a.k0.b> {
        public static final a a = new a();

        @Override // k.a.a.a.m0.a
        public boolean a(k.a.a.a.k0.b bVar, k.a.a.a.k0.b bVar2) {
            k.a.a.a.k0.b bVar3 = bVar;
            k.a.a.a.k0.b bVar4 = bVar2;
            if (bVar3 == bVar4) {
                return true;
            }
            return bVar3 != null && bVar4 != null && bVar3.a.f8432b == bVar4.a.f8432b && bVar3.f8384c.equals(bVar4.f8384c);
        }

        @Override // k.a.a.a.m0.a
        public int b(k.a.a.a.k0.b bVar) {
            k.a.a.a.k0.b bVar2 = bVar;
            return c.b.a.m.f.I1(c.b.a.m.f.Y5(c.b.a.m.f.X5(7, bVar2.a.f8432b), bVar2.f8384c), 2);
        }
    }

    /* JADX INFO: compiled from: PredictionMode.java */
    public static class b extends k.a.a.a.m0.d<k.a.a.a.k0.b, BitSet> {
        public b() {
            super(a.a);
        }
    }

    public static boolean allConfigsInRuleStopStates(c cVar) {
        Iterator<k.a.a.a.k0.b> it = cVar.iterator();
        while (it.hasNext()) {
            if (!(it.next().a instanceof f1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean allSubsetsConflict(Collection<BitSet> collection) {
        return !hasNonConflictingAltSet(collection);
    }

    public static boolean allSubsetsEqual(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        BitSet next = it.next();
        while (it.hasNext()) {
            if (!it.next().equals(next)) {
                return false;
            }
        }
        return true;
    }

    public static BitSet getAlts(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            bitSet.or(it.next());
        }
        return bitSet;
    }

    public static Collection<BitSet> getConflictingAltSubsets(c cVar) {
        b bVar = new b();
        for (k.a.a.a.k0.b bVar2 : cVar) {
            BitSet bitSet = (BitSet) bVar.get(bVar2);
            if (bitSet == null) {
                bitSet = new BitSet();
                bVar.put(bVar2, bitSet);
            }
            bitSet.set(bVar2.f8383b);
        }
        return bVar.values();
    }

    public static int getSingleViableAlt(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().nextSetBit(0));
            if (bitSet.cardinality() > 1) {
                return 0;
            }
        }
        return bitSet.nextSetBit(0);
    }

    public static Map<i, BitSet> getStateToAltMap(c cVar) {
        HashMap map = new HashMap();
        for (k.a.a.a.k0.b bVar : cVar) {
            BitSet bitSet = (BitSet) map.get(bVar.a);
            if (bitSet == null) {
                bitSet = new BitSet();
                map.put(bVar.a, bitSet);
            }
            bitSet.set(bVar.f8383b);
        }
        return map;
    }

    public static int getUniqueAlt(Collection<BitSet> collection) {
        BitSet alts = getAlts(collection);
        if (alts.cardinality() == 1) {
            return alts.nextSetBit(0);
        }
        return 0;
    }

    public static boolean hasConfigInRuleStopState(c cVar) {
        Iterator<k.a.a.a.k0.b> it = cVar.iterator();
        while (it.hasNext()) {
            if (it.next().a instanceof f1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasConflictingAltSet(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().cardinality() > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNonConflictingAltSet(Collection<BitSet> collection) {
        Iterator<BitSet> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().cardinality() == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSLLConflictTerminatingPrediction(b1 b1Var, c cVar) {
        if (allConfigsInRuleStopStates(cVar)) {
            return true;
        }
        if (b1Var == SLL && cVar.f8393f) {
            c cVar2 = new c(true);
            for (k.a.a.a.k0.b bVar : cVar) {
                cVar2.b(new k.a.a.a.k0.b(bVar, bVar.a, bVar.f8384c, h1.a), null);
            }
            cVar = cVar2;
        }
        return hasConflictingAltSet(getConflictingAltSubsets(cVar)) && !hasStateAssociatedWithOneAlt(cVar);
    }

    public static boolean hasStateAssociatedWithOneAlt(c cVar) {
        Iterator<BitSet> it = getStateToAltMap(cVar).values().iterator();
        while (it.hasNext()) {
            if (it.next().cardinality() == 1) {
                return true;
            }
        }
        return false;
    }

    public static int resolvesToJustOneViableAlt(Collection<BitSet> collection) {
        return getSingleViableAlt(collection);
    }

    public static BitSet getAlts(c cVar) {
        BitSet bitSet = new BitSet();
        Iterator<k.a.a.a.k0.b> it = cVar.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().f8383b);
        }
        return bitSet;
    }
}
