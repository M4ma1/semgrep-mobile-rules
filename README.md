# Правила Semgrep для безопасности мобильных приложений

Объединённый набор правил Semgrep для статического анализа безопасности
Android-, iOS-, React Native/Expo- и Flutter-приложений. Репозиторий объединяет
правила из нескольких исходных проектов, включая официальные проверки OWASP
MASTG и MobSF, сохраняя оригинальную логику правил и сведения об их авторах.

Дополнительно импортированы Swift-проверки Akabe1 и Android Java/Kotlin
проверки Federico Dotta. Независимые локальные правила закрывают найденные при
исследовании пробелы без копирования материалов из репозиториев без лицензии.

## Количество правил

| Платформа | Количество правил |
| --- | ---: |
| Android | 276 |
| iOS | 68 |
| React Native / Expo | 32 |
| Flutter / Dart | 23 |
| **Всего** | **399** |

## Структура репозитория

```text
rules/
├── android/                 # Правила для Java, Kotlin, AndroidManifest и Gradle
│   ├── architecture/        # Обновление приложения и архитектурные меры защиты
│   ├── authentication/      # Аутентификация и использование биометрии
│   ├── code/                # Защита релизных сборок, отладочный и нативный код
│   ├── cryptography/        # Алгоритмы, ключи, IV, хеши и случайные значения
│   ├── network/             # TLS, сертификаты и certificate pinning
│   ├── platform/            # WebView, IPC, компоненты, Intent и разрешения
│   ├── resilience/          # Правила защиты от модификации и анализа приложения
│   └── storage/             # Логи, резервные копии, UI и локальное хранение
├── ios/                     # Правила для Swift и конфигурации iOS
│   ├── authentication/      # Биометрическая аутентификация
│   ├── code/                # SQL/NoSQL и log injection
│   ├── cryptography/        # Алгоритмы, хеши, ключи и случайные значения
│   ├── network/             # Настройки App Transport Security
│   ├── platform/            # URL-схемы, Pasteboard, WebView и IPC
│   └── storage/             # Keychain, защита файлов, базы данных и логи
├── react-native/            # JavaScript, TypeScript, TSX и Expo configuration
│   ├── authentication/      # OAuth/PKCE, JWT, random и TextInput
│   ├── code/                # Dynamic execution, logging и supply chain
│   ├── configuration/       # Expo app.json и OTA updates
│   ├── network/             # HTTP, WebSocket, TLS и timeout
│   ├── platform/            # Linking, NativeModules, navigation и WebView
│   └── storage/             # AsyncStorage, MMKV, Realm и SecureStore
└── flutter/                 # Dart и Flutter API
    ├── code/                # SQL/command/HTML/path/channel injection
    ├── cryptography/        # Слабые хеши и случайные значения
    ├── network/             # HTTP, WebSocket, TLS и WebView
    ├── resilience/          # Обфускация и динамическое выполнение
    └── storage/             # SharedPreferences, clipboard и секреты

tests/                       # Тесты и исходные upstream-примеры
├── android/                 # Тесты, повторяющие структуру rules/android/
├── ios/                     # Тесты, повторяющие структуру rules/ios/
├── react-native/            # Тесты, повторяющие структуру rules/react-native/
├── flutter/                 # Тесты, повторяющие структуру rules/flutter/
└── upstream/                # Исходные демонстрационные файлы без test-аннотаций
docs/
└── SOURCES.md               # Исходные проекты и сведения о лицензировании
```

К идентификаторам правил из проекта InsideApp добавлены префиксы `android.`
или `ios.`. Это делает общую конфигурацию корректной, когда аналогичные проверки
существуют для обеих платформ. Исходные идентификаторы `MSTG-*` не изменялись.
Импортированные правила OWASP и MobSF используют пространства имён
`android.owasp.*` и `android.mobsf.*` соответственно.
Правила новых источников используют пространства `ios.akabe1.*` и
`android.federicodotta.*`, а независимо разработанные проверки —
`android.local.*` и `ios.local.*`.
Правила для гибридных приложений используют пространства `react-native.*`,
`flutter.*` и `flutter.apiiro.*`.
Правила GitLab SAST используют пространства `android.gitlab.*` и
`ios.gitlab.*`.

## Использование

Установите Semgrep и запустите проверку со всеми правилами:

```bash
semgrep scan --config rules/ path/to/application/source
```

Чтобы проверить только одну платформу или область безопасности:

```bash
semgrep scan --config rules/android/ path/to/android/source
semgrep scan --config rules/ios/ path/to/ios/source
semgrep scan --config rules/react-native/ path/to/react-native/source
semgrep scan --config rules/flutter/ path/to/flutter/source
semgrep scan --config rules/android/cryptography/ path/to/android/source
```

Запуск тестов:

```bash
semgrep scan --test --config rules/ tests/
```

Актуальный результат проверки на Semgrep 1.157:

- конфигурация валидна: 399 правил, 0 ошибок;
- 282 из 282 unit-тестов проходят;
- повторяющиеся ID и поведенчески идентичные правила отсутствуют;
- legacy-правило `MSTG-ARCH-9` валидируется, но его экспериментальный
  `mode: join` завершается runtime-ошибкой в Semgrep 1.157.

Результаты Semgrep следует рассматривать как отправную точку для ручного
анализа. Некоторые проверки намеренно ориентированы на широкий охват и могут
давать ложные срабатывания, поэтому специалисту по безопасности необходимо
учитывать контекст приложения.
