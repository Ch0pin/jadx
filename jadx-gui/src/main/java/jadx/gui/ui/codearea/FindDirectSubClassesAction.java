package jadx.gui.ui.codearea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jadx.gui.treemodel.JClass;
import jadx.gui.treemodel.JNode;
import jadx.gui.ui.MainWindow;
import jadx.gui.ui.action.ActionModel;
import jadx.gui.ui.dialog.UsageDialog;


public class FindDirectSubClassesAction extends JNodeAction{
    private static final Logger LOG = LoggerFactory.getLogger(FindDirectSubClassesAction.class);
	private static final long serialVersionUID = 3084073927621269039L;

	public FindDirectSubClassesAction(CodeArea codeArea) {
		super(ActionModel.FIND_DIRECT_SUBCLASSES, codeArea);
	}

	@Override
	public void runAction(JNode node) {
		MainWindow mw = getCodeArea().getMainWindow();
		UsageDialog usageDialog = new UsageDialog(mw, node);
		mw.addLoadListener(loaded -> {
			if (!loaded) {
				usageDialog.dispose();
				return true;
			}
			return false;
		});
		usageDialog.setVisible(true);
	}

    @Override
	public boolean isActionEnabled(JNode node) {
		return node instanceof JClass;
	}
}
