package ru.nsu.fit.tropin.View.GView;

import java.awt.*;

import static ru.nsu.fit.tropin.Model.Resources.BUTTON_HEIGHT;
import static ru.nsu.fit.tropin.Model.Resources.BUTTON_WIDTH;

public class ButtonsGameLayout implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component comp = parent.getComponent(i);
            int areaWidth = parent.getWidth() / 3;
            areaWidth = areaWidth - areaWidth % 10;
            comp.setBounds(areaWidth - BUTTON_WIDTH + i * (areaWidth + BUTTON_WIDTH),
                    parent.getHeight() - BUTTON_HEIGHT,
                    BUTTON_WIDTH, BUTTON_HEIGHT);
        }
    }
}
