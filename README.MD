# Compose Multiplatform Application

### Run backend

```bash
# Generate database
./gradlew :backend:modules:parser:run
```

Move generated database to `:backend:web-api`

```bash
# run web-api
./gradlew :backend:web-api:run
```

### Run app

```bash
# Run the desktop application
./gradlew :composeApp:run
# Build iOS Framework and open iOS Project
./gradlew :composeApp:assembleComposeAppReleaseXCFramework
```
