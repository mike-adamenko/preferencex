package com.github.adamenko.prefs;

import java.io.File;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

/**
 * PreferencesFactory implementation that stores the preferences in a user-defined file. To use it,
 * set the system property <tt>java.util.prefs.PreferencesFactory</tt> to
 * <tt>FilePreferencesFactory</tt>
 * <p/>
 * The file defaults to [user.home]/.fileprefs, but may be overridden with the system property
 * <tt>FilePreferencesFactory.file</tt>
 */
public class FilePreferencesFactory implements PreferencesFactory {
    private static final Logger log = Logger.getLogger(FilePreferencesFactory.class.getName());

    private Preferences rootPreferences;
    public static final String SYSTEM_PROPERTY_FILE =
            "FilePreferencesFactory.file";

    public Preferences systemRoot() {
        return userRoot();
    }

    public Preferences userRoot() {
        if (rootPreferences == null) {
            log.finer("Instantiating root preferences");

            rootPreferences = new FilePreferences(null, "");
        }
        return rootPreferences;
    }

    private static File preferencesFile;

    public static File getPreferencesFile() {
        if (preferencesFile == null) {
            String prefsFile = System.getProperty(SYSTEM_PROPERTY_FILE);
            if (prefsFile == null || prefsFile.length() == 0) {
                prefsFile = System.getProperty("user.home") + File.separator + ".fileprefs";
            }
            preferencesFile = new File(prefsFile).getAbsoluteFile();
            log.finer("Preferences file is " + preferencesFile);
        }
        return preferencesFile;
    }
}