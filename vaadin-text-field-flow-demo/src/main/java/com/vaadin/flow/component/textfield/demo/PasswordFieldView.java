/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.component.textfield.demo;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.textfield.GeneratedVaadinPasswordField;
import com.vaadin.flow.component.textfield.GeneratedVaadinTextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * View for {@link GeneratedVaadinPasswordField} demo.
 *
 * @author Vaadin Ltd
 */
@Route("vaadin-password-field")
public class PasswordFieldView extends DemoView {

    @Override
    public void initView() {
        addBasicField();
        addClearButtonFeature();
        addDisabledField();
        addVariantsFeature();
        addFocusShortcut();
    }

    private void addFocusShortcut() {
        // begin-source-example
        // source-example-heading: Focus shortcut usage
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Press ALT + 1 to focus");
        passwordField.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
        // end-source-example

        passwordField.setId("shortcut-field");
        this.addCard("Focus shortcut usage", passwordField);
    }

    private void addVariantsFeature() {
        // begin-source-example
        // source-example-heading: Theme variants usage
        PasswordField passwordField = new PasswordField();
        passwordField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        // end-source-example

        addVariantsDemo(PasswordField::new,
                GeneratedVaadinTextField::addThemeVariants,
                GeneratedVaadinTextField::removeThemeVariants,
                TextFieldVariant::getVariantName, TextFieldVariant.LUMO_SMALL);
    }

    private void addBasicField() {
        Div message = new Div();

        // begin-source-example
        // source-example-heading: Basic password field
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password field label");
        passwordField.setPlaceholder("placeholder text");
        passwordField.addValueChangeListener(event -> message.setText(
                String.format("Password field value changed from '%s' to '%s'",
                        event.getOldValue(), event.getValue())));
        NativeButton button = new NativeButton("Toggle eye icon", event -> {
            passwordField.setRevealButtonVisible(
                    !passwordField.isRevealButtonVisible());
        });
        // end-source-example

        passwordField.setId("password-field-with-value-change-listener");
        message.setId("password-field-value");
        button.setId("toggle-button");

        addCard("Basic password field", button, passwordField,
                new ValueChangeModeButtonProvider(passwordField)
                        .getValueChangeModeRadios(),
                message);
    }

    private void addClearButtonFeature() {
        // begin-source-example
        // source-example-heading: Password field with clear button
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password field label");
        passwordField.setPlaceholder("placeholder text");
        NativeButton clearButton = new NativeButton("Toggle clear button", event -> {
            passwordField.setClearButtonVisible(
                    !passwordField.isClearButtonVisible());
        });
        // end-source-example

        addCard("Password field with clear button", passwordField, clearButton);
    }

    private void addDisabledField() {
        // begin-source-example
        // source-example-heading: Disabled password field
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password field label");
        passwordField.setPlaceholder("placeholder text");
        passwordField.setEnabled(false);
        // end-source-example

        passwordField.setId("disabled-password-field");
        Div message = new Div();
        message.setId("disabled-password-field-message");
        passwordField.addValueChangeListener(
                change -> message.setText("password changed"));

        addCard("Disabled password field", passwordField, message);
    }
}
