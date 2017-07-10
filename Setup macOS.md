# General

## Homebrew

Install homebrew and update it
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
brew update
```

## Node

Install:
```
brew install node@6
```

Latest node@6 keg install `npm5` which is significantly different compared to `npm4` so I would recommend force install `npm4`:
```
npm i -g npm@4
```

## Appium Server

```
npm i -g appium@1.6.5
```

# Android Tools

## Java

Install:
```
brew cask install java
```

Add JAVA_HOME to `~/.bash_profile`:
```
echo 'export JAVA_HOME="$(/usr/libexec/java_home -v 1.8)"' >> ~/.bash_profile
```

Re-laod `~/.bash_profile`:
```
source ~/.bash_profile
```

## Android SDK

Install:
```
brew cask install android-sdk
```

(Optional) You may want to add to your profile:
```
export ANDROID_HOME=/usr/local/share/android-sdk
export ANDROID_SDK_ROOT=/usr/local/share/android-sdk
```


Add SDKs and Tools:
```
$ANDROID_HOME/tools/bin/sdkmanager "platform-tools"
$ANDROID_HOME/tools/bin/sdkmanager "tools"
$ANDROID_HOME/tools/bin/sdkmanager "build-tools;26.0.0"
$ANDROID_HOME/tools/bin/sdkmanager "build-tools;25.0.3"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-26"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-25"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-24"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-23"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-22"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-21"
$ANDROID_HOME/tools/bin/sdkmanager "platforms;android-19"
$ANDROID_HOME/tools/bin/sdkmanager "emulator"
$ANDROID_HOME/tools/bin/sdkmanager "extras;android;m2repository"
$ANDROID_HOME/tools/bin/sdkmanager "extras;google;m2repository"
```

Install HAXM:
```
$ANDROID_HOME/tools/bin/sdkmanager "extras;intel;Hardware_Accelerated_Execution_Manager"
sudo $ANDROID_HOME/extras/intel/Hardware_Accelerated_Execution_Manager/silent_install.sh
```

Download Emulator Images:
```
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-26;google_apis_playstore;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-25;google_apis;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-24;google_apis;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-23;google_apis;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-22;google_apis;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-21;google_apis;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-19;google_apis;x86"
echo yes | $ANDROID_HOME/tools/bin/sdkmanager "system-images;android-19;default;x86"
```

Create Emulators:
```
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api19-Default -k "system-images;android-19;default;x86" -b default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api19-Google -k "system-images;android-19;google_apis;x86" -b google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api21-Google -k "system-images;android-21;google_apis;x86" -b google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api22-Google -k "system-images;android-22;google_apis;x86" -b google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api23-Google -k "system-images;android-23;google_apis;x86" -b google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api24-Google -k "system-images;android-24;google_apis;x86" -b google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api25-Google -k "system-images;android-25;google_apis;x86" -b google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/bin/avdmanager create avd -n Emulator-Api26-Google -k "system-images;android-26;google_apis_playstore;x86" -b google_apis_playstore/x86 -c 12M -f
```

(Optional) Build Edit Settings:
```
find ~/.android/avd -type f -name 'config.ini' -exec bash -c 'echo $0 && echo "hw.lcd.density=240" | tee -a $0 && echo "skin.name=480x800" | tee -a $0 && echo "hw.gpu.enabled=yes"  | tee -a $0 && echo "hw.keyboard=no" | tee -a $0 && cat $0' {} \;
```

Start Emulators:
```
$ANDROID_HOME/tools/emulator -avd Emulator-Api19-Default
```

Run UI Tree Inspector:
```
TODO
```

# iOS Tools

Those examples might work on ElCapitan, but I highly recommend update to macOS Sierra.
macOS Sierra is required to run Xcode 8.3+ (test on iOS 10.3+ devices and simulators).

## Xcode

Get latest official Xcode and install it.

## Appium Dependencies

Install dependencies of Appium and other helpful tools
```
brew install --HEAD libimobiledevice
brew link --overwrite libimobiledevice && true
brew install --HEAD ideviceinstaller
brew link --overwrite ideviceinstaller && true
brew install ios-webkit-debug-proxy
brew install carthage
npm install -g -f deviceconsole
npm install -g -f ios-deploy
```