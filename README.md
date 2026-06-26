# Legado App (No Ads)

基于 legado（阅读）开源项目的二次开发版本，已移除所有广告。

## 已移除的广告功能

- ✅ 开屏广告（SplashActivity 已改为直接跳转主页）
- ✅ 激励视频广告（每2小时强制弹窗已移除）
- ✅ 阅读页 Banner 广告
- ✅ 搜索页广告
- ✅ 书架广告
- ✅ 穿山甲广告 SDK 初始化
- ✅ 广点通广告 SDK 初始化
- ✅ 友盟统计初始化

## 修改的核心文件

| 文件 | 修改内容 |
|---|---|
| `app/src/main/java/io/legado/app/model/AdsConfig.java` | 所有 `getEnable*()` 方法返回 `false` |
| `app/src/main/java/io/legado/app/ui/welcome/SplashActivity.java` | 跳过开屏广告，直接进入主页 |
| `app/src/main/java/io/legado/app/App.java` | 注释掉广告 SDK 初始化代码 |

## 编译说明

### 本地编译

1. 用 Android Studio 打开项目
2. 补充 `app/build.gradle` 中缺失的依赖
3. 运行 `./gradlew assembleDebug`

### GitHub Actions 编译

1. 将代码推送到 GitHub 仓库
2. 在 Actions 页面手动触发构建
3. 下载生成的 APK

## 注意事项

- 这是从 APK 反编译的代码，部分变量名可能不直观
- `app/build.gradle` 中的 dependencies 需要手动补充（jadx 导出时未自动解析）
- 签名需要自行配置（原始签名已丢失）
- 基于 legado (GPL-3.0) 开源项目
