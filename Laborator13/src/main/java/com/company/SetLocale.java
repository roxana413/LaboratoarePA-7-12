package com.company;

import app.LocaleContext;

public class SetLocale {

    public SetLocale(String languageTag)
    {
        LocaleContext.setLocale(languageTag);
    }
}
