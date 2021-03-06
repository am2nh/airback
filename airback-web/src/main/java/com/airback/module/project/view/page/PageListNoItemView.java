/**
 * Copyright © airback
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.airback.module.project.view.page;

import com.airback.common.i18n.GenericI18Enum;
import com.airback.module.project.CurrentProjectVariables;
import com.airback.module.project.ProjectRolePermissionCollections;
import com.airback.module.project.ProjectTypeConstants;
import com.airback.module.project.event.PageEvent;
import com.airback.module.project.i18n.PageI18nEnum;
import com.airback.module.project.ui.ProjectAssetsManager;
import com.airback.module.project.ui.components.ProjectListNoItemView;
import com.airback.vaadin.EventBusFactory;
import com.airback.vaadin.UserUIContext;
import com.airback.vaadin.web.ui.WebThemes;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.layouts.MHorizontalLayout;

/**
 * @author airback Ltd.
 * @since 5.0.2
 */
public class PageListNoItemView extends ProjectListNoItemView {
    @Override
    protected VaadinIcons viewIcon() {
        return ProjectAssetsManager.getAsset(ProjectTypeConstants.PAGE);
    }

    @Override
    protected String viewTitle() {
        return UserUIContext.getMessage(GenericI18Enum.VIEW_NO_ITEM_TITLE);
    }

    @Override
    protected String viewHint() {
        return UserUIContext.getMessage(GenericI18Enum.VIEW_NO_ITEM_HINT);
    }

    @Override
    protected String actionMessage() {
        return UserUIContext.getMessage(PageI18nEnum.NEW);
    }

    @Override
    protected Button.ClickListener actionListener() {
        return new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                EventBusFactory.getInstance().post(new PageEvent.GotoAdd(this, null));
            }
        };
    }

    protected MHorizontalLayout createControlButtons() {
        if (hasPermission()) {
            MButton createPageBtn = new MButton(actionMessage(), actionListener()).withStyleName(WebThemes.BUTTON_ACTION);

            MButton createPageGroupBtn = new MButton(UserUIContext.getMessage(PageI18nEnum.NEW_GROUP), clickEvent -> UI.getCurrent().addWindow(new GroupPageAddWindow())).withStyleName(WebThemes.BUTTON_ACTION);

            return new MHorizontalLayout(createPageBtn, new Label(" or "), createPageGroupBtn)
                    .alignAll(Alignment.MIDDLE_CENTER);
        } else {
            return new MHorizontalLayout();
        }
    }

    @Override
    protected boolean hasPermission() {
        return CurrentProjectVariables.canWrite(ProjectRolePermissionCollections.PAGES);
    }
}