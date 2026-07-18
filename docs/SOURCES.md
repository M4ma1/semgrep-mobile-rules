# Источники и авторство

Этот репозиторий объединяет правила из следующих исходных проектов:

| Источник | Использованные материалы | Расположение в этом репозитории |
| --- | --- | --- |
| [mindedsecurity/semgrep-rules-android-security](https://github.com/mindedsecurity/semgrep-rules-android-security) | Правила для Android, соответствующие OWASP MASTG 1.5.0, и тестовые примеры | `rules/android/` и `tests/android/`; идентификаторы правил начинаются с `MSTG-` |
| [insideapp-oss/mobile-application-security-rules](https://github.com/insideapp-oss/mobile-application-security-rules) | Правила и тестовые примеры для Android и iOS | `rules/android/`, `rules/ios/`, `tests/android/` и `tests/ios/`; идентификаторы начинаются с `android.` или `ios.` |
| [OWASP/mastg](https://github.com/OWASP/mastg) | Официальные Android-проверки OWASP MASTG | `rules/android/`; идентификаторы начинаются с `android.owasp.` |
| [MobSF/mobsfscan](https://github.com/MobSF/mobsfscan) | Android Semgrep-правила и Java fixtures | `rules/android/` и `tests/android/`; идентификаторы начинаются с `android.mobsf.` |
| [semgrep/semgrep-rules](https://github.com/semgrep/semgrep-rules) | Android, Kotlin, Gradle и Swift rules и fixtures | `rules/android/`, `rules/ios/` и `tests/`; идентификаторы начинаются с `android.semgrep.` или `ios.semgrep.` |
| [gitlab-org/security-products/sast-rules](https://gitlab.com/gitlab-org/security-products/sast-rules) | Kotlin, Swift и Objective-C rules и fixtures | `rules/android/`, `rules/ios/` и `tests/`; идентификаторы начинаются с `android.gitlab.` или `ios.gitlab.` |
| [akabe1/akabe1-semgrep-rules](https://github.com/akabe1/akabe1-semgrep-rules) | 24 Swift-правила и демонстрационные примеры | `rules/ios/` и `tests/upstream/akabe1/`; идентификаторы начинаются с `ios.akabe1.` |
| [federicodotta/semgrep-rules](https://github.com/federicodotta/semgrep-rules) | Четыре Android Java/Kotlin правила и примеры | `rules/android/` и `tests/upstream/federicodotta/`; идентификаторы начинаются с `android.federicodotta.` |
| [adnxy/rnsec](https://github.com/adnxy/rnsec) | Сценарии проверок React Native и Expo, адаптированные под Semgrep AST/taint | `rules/react-native/`; идентификаторы начинаются с `react-native.` |
| [apiiro/malicious-code-ruleset](https://github.com/apiiro/malicious-code-ruleset) | Dart-правила обфускации и динамического выполнения | `rules/flutter/resilience/`; идентификаторы начинаются с `flutter.apiiro.` |

Для объединённого репозитория используется GNU GPL версии 3, поскольку исходный
проект Minded Security распространяется по этой лицензии. Полный текст приведён
в файле [`LICENSE`](../LICENSE). При изменении или распространении правил
необходимо сохранять сведения об авторах, метаданные и ссылки, указанные внутри
отдельных правил.

На момент объединения в локальной копии исходного проекта InsideApp отсутствовал
файл лицензии верхнего уровня. Происхождение этих правил задокументировано здесь,
чтобы не создавать впечатление, что они были разработаны в этом репозитории.
Перед публикацией объединённого набора необходимо уточнить условия
распространения у авторов исходного проекта.

## Версии импортированных источников

- OWASP MASTG: commit `a1b0e11`.
- MobSF/mobsfscan: commit `ec2927a`.
- Semgrep community rules: commit `e5b5a42`.
- GitLab SAST Rules: commit `d580ded`.
- Akabe1 Semgrep Rules: commit `db843f1`.
- Federico Dotta Semgrep Rules: commit `51b9b69`.
- RNSEC: commit `7035520`.
- Apiiro Malicious Code Ruleset: commit `a21246b`.

Правила OWASP MASTG распространяются по CC BY-SA 4.0. Копия лицензии находится
в [`licenses/OWASP-MASTG-CC-BY-SA-4.0.md`](../licenses/OWASP-MASTG-CC-BY-SA-4.0.md).
Правила MobSF/mobsfscan распространяются по LGPLv3; копия находится в
[`licenses/MOBSFSCAN-LGPL-3.0.txt`](../licenses/MOBSFSCAN-LGPL-3.0.txt).

Импортированные правила GitLab содержат LGPLv3 license headers либо основаны на
материалах с указанной в файле исходной лицензией. Копия общей лицензии
репозитория находится в
[`licenses/GITLAB-SAST-RULES-LICENSE.txt`](../licenses/GITLAB-SAST-RULES-LICENSE.txt).

Swift-правила Akabe1 распространяются по GPLv3-or-later согласно upstream
README; сведения сохранены в
[`licenses/AKABE1-GPL-3.0-NOTICE.md`](../licenses/AKABE1-GPL-3.0-NOTICE.md).
Правила Federico Dotta распространяются по MIT; копия находится в
[`licenses/FEDERICODOTTA-MIT.txt`](../licenses/FEDERICODOTTA-MIT.txt).

RNSEC распространяется по MIT; копия находится в
[`licenses/RNSEC-MIT.txt`](../licenses/RNSEC-MIT.txt). Его TypeScript scanner не
копировался: сценарии заново выражены через Semgrep patterns и taint mode.
Apiiro Malicious Code Ruleset также распространяется по MIT; копия находится в
[`licenses/APIIRO-MALICIOUS-CODE-MIT.txt`](../licenses/APIIRO-MALICIOUS-CODE-MIT.txt).

Репозиторий `iter-malum/semgrep_rules` не содержит явной лицензии. Его Dart YAML
не включён в этот проект; перечень категорий использовался только для исследования,
а Flutter patterns и сообщения были реализованы независимо.
