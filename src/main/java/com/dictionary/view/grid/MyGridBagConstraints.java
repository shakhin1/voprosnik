package com.dictionary.view.grid;

import java.awt.*;

public class MyGridBagConstraints extends GridBagConstraints {
	public MyGridBagConstraints(int ipady, int ipadx, int gridx, int gridy, int gridwidth, int gridheight) {
		this.fill = GridBagConstraints.HORIZONTAL;
		this.ipady = ipady;
		this.ipadx = ipadx;
		this.insets = new Insets(1, 1, 1, 1);
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
}
