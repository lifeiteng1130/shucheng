package org.mozilla.javascript.optimizer;

import java.util.Map;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.NodeTransformer;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: loaded from: classes3.dex */
public class OptTransformer extends NodeTransformer {
    private ObjArray directCallTargets;
    private Map<String, OptFunctionNode> possibleDirectCalls;

    public OptTransformer(Map<String, OptFunctionNode> map, ObjArray objArray) {
        this.possibleDirectCalls = map;
        this.directCallTargets = objArray;
    }

    private void detectDirectCall(Node node, ScriptNode scriptNode) {
        OptFunctionNode optFunctionNode;
        if (scriptNode.getType() == 110) {
            Node firstChild = node.getFirstChild();
            int i2 = 0;
            Node next = firstChild.getNext();
            while (next != null) {
                next = next.getNext();
                i2++;
            }
            if (i2 == 0) {
                OptFunctionNode.get(scriptNode).itsContainsCalls0 = true;
            }
            if (this.possibleDirectCalls != null) {
                String string = null;
                if (firstChild.getType() == 39) {
                    string = firstChild.getString();
                } else if (firstChild.getType() == 33) {
                    string = firstChild.getFirstChild().getNext().getString();
                } else if (firstChild.getType() == 34) {
                    throw Kit.codeBug();
                }
                if (string == null || (optFunctionNode = this.possibleDirectCalls.get(string)) == null || i2 != optFunctionNode.fnode.getParamCount() || optFunctionNode.fnode.requiresActivation() || i2 > 32) {
                    return;
                }
                node.putProp(9, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    return;
                }
                int size = this.directCallTargets.size();
                this.directCallTargets.add(optFunctionNode);
                optFunctionNode.setDirectTargetIndex(size);
            }
        }
    }

    @Override // org.mozilla.javascript.NodeTransformer
    public void visitCall(Node node, ScriptNode scriptNode) {
        detectDirectCall(node, scriptNode);
        super.visitCall(node, scriptNode);
    }

    @Override // org.mozilla.javascript.NodeTransformer
    public void visitNew(Node node, ScriptNode scriptNode) {
        detectDirectCall(node, scriptNode);
        super.visitNew(node, scriptNode);
    }
}
