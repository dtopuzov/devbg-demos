# Mobile Testing – From Zero to Hero

## About

This is demo project for [Mobile Testing – From Zero to Hero](http://dev.bg/%D1%81%D1%8A%D0%B1%D0%B8%D1%82%D0%B8%D0%B5/mobile-testing-from-zero-to-hero/) event of DevBG's Software Quality Assurance user group.

## Setup 

Please read [Setup macOS](Setup macOS.md) document.

## Run Tests

Attach Android device with enabled USB debugging or start emulator:
```
$ANDROID_HOME/tools/emulator -avd Emulator-Api19-Default
```

Manually start Appium Server:
```
appium
```

Execute tests for Selendroid app
```
./gradlew clean test --tests tests.Selendroid
```

Execute tests for Google home page
```
./gradlew clean test --tests tests.Google
```

Execute tests for UICatalog iOS Application
```
./gradlew clean test --tests tests.UICatalog
```

## Check for code style and errors

[Checkstyle](https://docs.gradle.org/current/userguide/checkstyle_plugin.html) is used to check code style.

Rules are listed in `config/checkstyle/checkstyle.xml`

`build` and `test` tasks dependes on `check`, so checks will be executed each time when you build or run tests.

Task depencies are defined in `build.gradle`
```
build.dependsOn(check)
test.dependsOn(check)
check.dependsOn.remove(test)
```

## Additional Resources

### Mobile Web Testing

[Appium Docs](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/mobile-web.md)

[Chrome Driver Docs](https://sites.google.com/a/chromium.org/chromedriver/getting-started/getting-started---android)