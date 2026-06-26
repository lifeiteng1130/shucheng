package org.seimicrawler.xpath.exception;

import k.a.a.a.a0;
import k.a.a.a.d0;
import k.a.a.a.m0.l;
import k.a.a.a.n;
import k.a.a.a.p;
import k.a.a.a.w;
import k.a.a.a.y;

/* JADX INFO: loaded from: classes3.dex */
public class DoFailOnErrorHandler extends n {
    @Override // k.a.a.a.n, k.a.a.a.b
    public void recover(w wVar, a0 a0Var) {
        for (y context = wVar.getContext(); context != null; context = context.mo33getParent()) {
            context.exception = a0Var;
        }
        throw new l(a0Var);
    }

    @Override // k.a.a.a.n, k.a.a.a.b
    public d0 recoverInline(w wVar) {
        p pVar = new p(wVar);
        for (y context = wVar.getContext(); context != null; context = context.mo33getParent()) {
            context.exception = pVar;
        }
        throw new l(pVar);
    }
}
