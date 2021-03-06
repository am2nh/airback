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
package com.airback.module.project.view.settings;

import com.airback.common.i18n.SecurityI18nEnum;
import com.airback.core.UserInvalidInputException;
import com.airback.form.view.LayoutType;
import com.airback.module.project.CurrentProjectVariables;
import com.airback.module.project.ProjectRolePermissionCollections;
import com.airback.module.project.ProjectTypeConstants;
import com.airback.module.project.domain.ProjectMember;
import com.airback.module.project.domain.SimpleProjectMember;
import com.airback.module.project.domain.SimpleProjectRole;
import com.airback.module.project.i18n.ProjectMemberI18nEnum;
import com.airback.module.project.i18n.ProjectRoleI18nEnum;
import com.airback.module.project.i18n.RolePermissionI18nEnum;
import com.airback.module.project.service.ProjectRoleService;
import com.airback.module.project.ui.ProjectAssetsManager;
import com.airback.module.project.ui.components.AbstractEditItemComp;
import com.airback.module.project.view.settings.component.ProjectRoleComboBox;
import com.airback.security.PermissionFlag;
import com.airback.security.PermissionMap;
import com.airback.spring.AppContextUtil;
import com.airback.vaadin.AppUI;
import com.airback.vaadin.UserUIContext;
import com.airback.vaadin.mvp.ViewComponent;
import com.airback.vaadin.ui.*;
import com.airback.vaadin.ui.field.DefaultViewField;
import com.airback.vaadin.web.ui.WebThemes;
import com.airback.vaadin.web.ui.grid.GridFormLayoutHelper;
import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import org.vaadin.viritin.fields.DoubleField;
import org.vaadin.viritin.layouts.MVerticalLayout;

import static com.airback.vaadin.web.ui.utils.FormControlsGenerator.generateEditFormControls;

/**
 * @author airback Ltd.
 * @since 1.0
 */
@ViewComponent
public class ProjectMemberEditViewImpl extends AbstractEditItemComp<SimpleProjectMember> implements ProjectMemberEditView {
    private static final long serialVersionUID = 1L;

    private GridFormLayoutHelper projectFormHelper;

    @Override
    protected String initFormHeader() {
        return (beanItem.getId() == null) ? UserUIContext.getMessage(ProjectMemberI18nEnum.NEW) :
                UserUIContext.getMessage(ProjectMemberI18nEnum.DETAIL);
    }

    @Override
    protected String initFormTitle() {
        return (beanItem.getId() == null) ? null : beanItem.getDisplayName();
    }

    @Override
    protected VaadinIcons initFormIconResource() {
        return ProjectAssetsManager.getAsset(ProjectTypeConstants.MEMBER);
    }

    @Override
    protected ComponentContainer createButtonControls() {
        return generateEditFormControls(editForm,
                CurrentProjectVariables.canWrite(ProjectRolePermissionCollections.USERS), false, true);
    }

    @Override
    protected AdvancedEditBeanForm<SimpleProjectMember> initPreviewForm() {
        return new AdvancedEditBeanForm<>();
    }

    @Override
    protected IFormLayoutFactory initFormLayoutFactory() {
        return new DecorFormLayoutFactory(new ProjectMemberFormLayoutFactory());
    }

    @Override
    protected AbstractBeanFieldGroupEditFieldFactory<SimpleProjectMember> initBeanFormFieldFactory() {
        return new EditFormFieldFactory(editForm);
    }

    private class EditFormFieldFactory extends AbstractBeanFieldGroupEditFieldFactory<SimpleProjectMember> {
        private static final long serialVersionUID = 1L;

        EditFormFieldFactory(GenericBeanForm<SimpleProjectMember> form) {
            super(form);
        }

        @Override
        protected HasValue<?> onCreateField(final Object propertyId) {
            if (SimpleProjectMember.Field.memberFullName.equalTo(propertyId)) {
                return new DefaultViewField(beanItem.getMemberFullName());
            } else if (ProjectMember.Field.projectroleid.equalTo(propertyId)) {
                return new ProjectRoleSelectionField();
            } else if (ProjectMember.Field.billingrate.equalTo(propertyId) ||
                    ProjectMember.Field.overtimebillingrate.equalTo(propertyId)) {
                return new DoubleField().withWidth(WebThemes.FORM_CONTROL_WIDTH);
            }
            return null;
        }
    }

    private class DecorFormLayoutFactory extends WrappedFormLayoutFactory {

        DecorFormLayoutFactory(AbstractFormLayoutFactory formLayoutFactory) {
            this.wrappedLayoutFactory = formLayoutFactory;
        }

        @Override
        public AbstractComponent getLayout() {
            MVerticalLayout layout = new MVerticalLayout().withMargin(false).withSpacing(false);
            layout.addComponent(wrappedLayoutFactory.getLayout());

            FormContainer permissionsPanel = new FormContainer();
            projectFormHelper = GridFormLayoutHelper.defaultFormLayoutHelper(LayoutType.TWO_COLUMN);
            permissionsPanel.addSection(UserUIContext.getMessage(ProjectRoleI18nEnum.SECTION_PERMISSIONS),
                    projectFormHelper.getLayout());
            layout.addComponent(permissionsPanel);

            return layout;
        }
    }

    private void displayRolePermission(Integer roleId) {
        projectFormHelper.getLayout().removeAllComponents();
        if (roleId != null && roleId > 0) {
            ProjectRoleService roleService = AppContextUtil.getSpringBean(ProjectRoleService.class);
            SimpleProjectRole role = roleService.findById(roleId, AppUI.getAccountId());
            if (role != null) {
                PermissionMap permissionMap = role.getPermissionMap();
                for (int i = 0; i < ProjectRolePermissionCollections.PROJECT_PERMISSIONS.length; i++) {
                    String permissionPath = ProjectRolePermissionCollections.PROJECT_PERMISSIONS[i];
                    Enum permissionKey = RolePermissionI18nEnum.valueOf(permissionPath);
                    Integer perVal = permissionMap.get(permissionKey.name());
                    SecurityI18nEnum permissionVal = PermissionFlag.toVal(perVal);
                    projectFormHelper.addComponent(new Label(UserUIContext.getPermissionCaptionValue(
                            permissionMap, permissionPath)), UserUIContext.getMessage(permissionKey),
                            UserUIContext.getMessage(permissionVal.desc()), i % 2, i / 2);
                }
            }
        } else {
            throw new UserInvalidInputException("Invalid role id " + roleId);
        }
    }


    private class ProjectRoleSelectionField extends CustomField<Integer> {
        private static final long serialVersionUID = 1L;
        private ProjectRoleComboBox roleComboBox;

        ProjectRoleSelectionField() {
            roleComboBox = new ProjectRoleComboBox();
            roleComboBox.addValueChangeListener(valueChangeEvent -> {
                SimpleProjectRole selectedRole = roleComboBox.getValue();
                if (selectedRole != null) {
                    displayRolePermission(selectedRole.getId());
                }
            });
        }

        @Override
        protected Component initContent() {
            return roleComboBox;
        }

        @Override
        protected void doSetValue(Integer value) {
            roleComboBox.selectRoleById(value);
            displayRolePermission(value);
        }

        @Override
        public Integer getValue() {
            SimpleProjectRole role = roleComboBox.getSelectedItem().orElse(null);
            return (role != null) ? role.getId() : null;
        }
    }
}
