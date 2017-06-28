# preferencex
Library that extends [Java Preferences API](http://docs.oracle.com/javase/7/docs/technotes/guides/preferences/overview.html) to work with  file as the storage

## Usage

 To use it,
 * set the system property `java.util.prefs.PreferencesFactory` to `com.github.adamenk.prefs.FilePreferencesFactory`
 * The default properties file is `[user.home]/.fileprefs`, but may be overridden with the system property 
 `com.github.adamenk.prefs.FilePreferencesFactory.file`


Example:
```
System.setProperty("java.util.prefs.PreferencesFactory", FilePreferencesFactory.class.getName());
System.setProperty(SYSTEM_PROPERTY_FILE, "myprefs.txt");

Preferences p = Preferences.userNodeForPackage(this.getClass());

p.putBoolean("boolean.property", true);
p.put("string.property", "custom.property.value");

System.out.println("boolean.property: " + p.get("boolean.property", null));
System.out.println("string.property: " + p.get("string.property", null));
```

console output:

```
boolean.property: true
string.property: custom.property.value
```