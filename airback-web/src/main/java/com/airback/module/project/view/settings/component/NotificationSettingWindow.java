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
package com.airback.module.project.view.settings.component;

import com.airback.common.NotificationType;
import com.airback.common.i18n.GenericI18Enum;
import com.airback.core.airbackException;
import com.airback.module.project.domain.ProjectNotificationSetting;
import com.airback.module.project.domain.SimpleProjectMember;
import com.airback.module.project.i18n.ProjectCommonI18nEnum;
import com.airback.module.project.i18n.ProjectSettingI18nEnum;
import com.airback.module.project.service.ProjectNotificationSettingService;
import com.airback.spring.AppContextUtil;
import com.airback.vaadin.UserUIContext;
import com.airback.vaadin.ui.NotificationUtil;
import com.airback.vaadin.web.ui.WebThemes;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ItemCaptionGenerator;
import com.vaadin.ui.RadioButtonGroup;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;
import org.vaadin.viritin.layouts.MWindow;

/**
 * @author airback Ltd
 * @since 5.4.2
 */
public class NotificationSettingWindow extends MWindow {
    public NotificationSettingWindow(SimpleProjectMember projectMember) {
        super(UserUIContext.getMessage(ProjectCommonI18nEnum.ACTION_EDIT_NOTIFICATION));
        withModal(true).withResizable(false).withWidth("600px").withCenter();
        ProjectNotificationSettingService prjNotificationSettingService = AppContextUtil.getSpringBean(ProjectNotificationSettingService.class);
        ProjectNotificationSetting notification = prjNotificationSettingService.findNotification(projectMember.getUsername(), projectMember.getProjectid(),
                projectMember.getSaccountid());

        MVerticalLayout body = new MVerticalLayout();

        final RadioButtonGroup<String> optionGroup = new RadioButtonGroup(null);
        optionGroup.setItems(NotificationType.Default.name(), NotificationType.None.name(), NotificationType.Minimal.name(), NotificationType.Full.name());
        optionGroup.setItemCaptionGenerator((ItemCaptionGenerator<String>) item -> {
            if (item.equals(NotificationType.Default.name())) {
                return UserUIContext.getMessage(ProjectSettingI18nEnum.OPT_DEFAULT_SETTING);
            } else if (item.equals(NotificationType.None.name())) {
                return UserUIContext.getMessage(ProjectSettingI18nEnum.OPT_NONE_SETTING);
            } else if (item.equals(NotificationType.Minimal.name())) {
                return UserUIContext.getMessage(ProjectSettingI18nEnum.OPT_MINIMUM_SETTING);
            } else if (item.equals(NotificationType.Full.name())) {
                return UserUIContext.getMessage(ProjectSettingI18nEnum.OPT_MAXIMUM_SETTING);
            } else {
                throw new airbackException("Not supported");
            }
        });

        optionGroup.setWidth("100%");
        body.with(optionGroup);

        String levelVal = notification.getLevel();
        if (levelVal == null) {
            optionGroup.setValue(NotificationType.Default.name());
        } else {
            optionGroup.setValue(levelVal);
        }

        MButton closeBtn = new MButton(UserUIContext.getMessage(GenericI18Enum.BUTTON_CLOSE), clickEvent -> close())
                .withStyleName(WebThemes.BUTTON_OPTION);
        MButton saveBtn = new MButton(UserUIContext.getMessage(GenericI18Enum.BUTTON_SAVE), clickEvent -> {
            try {
                notification.setLevel(optionGroup.getValue());
                ProjectNotificationSettingService projectNotificationSettingService = AppContextUtil.getSpringBean(ProjectNotificationSettingService.class);

                if (notification.getId() == null) {
                    projectNotificationSettingService.saveWithSession(notification, UserUIContext.getUsername());
                } else {
                    projectNotificationSettingService.updateWithSession(notification, UserUIContext.getUsername());
                }
                NotificationUtil.showNotification(UserUIContext.getMessage(GenericI18Enum.OPT_CONGRATS),
                        UserUIContext.getMessage(ProjectSettingI18nEnum.DIALOG_UPDATE_SUCCESS));
                close();
            } catch (Exception e) {
                throw new airbackException(e);
            }
        }).withStyleName(WebThemes.BUTTON_ACTION).withIcon(VaadinIcons.CLIPBOARD)
                .withClickShortcut(ShortcutAction.KeyCode.ENTER);
        MHorizontalLayout btnControls = new MHorizontalLayout(closeBtn, saveBtn);
        body.with(btnControls).withAlign(btnControls, Alignment.TOP_RIGHT);

        withContent(body);
    }
}
