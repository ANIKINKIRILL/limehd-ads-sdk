# Библиотека LimeHD-Ads-Sdk

LimeHD-Ads-Sdk помагает разработчикам интегрировать рекламу в их приложения. Библиотека поддерживает несколько рекламных площадок

## Интеграция

### 0. Добавить `JitPack` в build.gradle файл
``` gradle
allprojects {
  repositories {
    ....
    maven { url 'https://jitpack.io' }
  }
}
```

### 1. Добавить dependency build.gradle
``` gradle
dependencies {
  implementation 'com.github.LimeHD:limehd-ads-sdk:X.X.X'
}
