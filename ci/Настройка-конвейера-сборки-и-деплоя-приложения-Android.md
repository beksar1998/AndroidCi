#Создание конвейера
##Переменные окружения

Для корректной работы агента сборки и сборщика gradle необходимо определить пути к SDK, файлу настройки ключа, путь к файлу Release Notes определив переменные на вкладке **"Переменные"** в настройках сборки:

```
ANDROID_HOME = [путь к директории SDK (/data/vsts/Android/Sdk/)]
ANDROID_SIGN_PROP = [Путь к файлу свойств ключа (/data/vsts/_work/keystore.properties)]
RELEASE_FILE = [путь к файлу Release (/data/vsts/_work/Release.txt)]
```
![env.png](/.attachments/env-fbde014b-afc4-489f-9a43-2455cfbd561a.png) 

##Настройка номера релиза
Для настройки номера релиза необходимо определить формат номера сборки на вкладке **"Параметры"** в настройках сборки:

`$(rev:r).$(BuildID)`

![release_number.png](/.attachments/release_number-8b9e8e93-32ad-4673-9050-d77c6b292892.png)

##Настройка выгрузки логов GIT (внесенных коммитов) для формирования releaseNotes и создания файла Release.txt
 

##Настройка файла gradlew


##Настройка /build.gradle, /common.gradle, /app/buld.gradle

## Настройка выгрузки бандла приложения в Play Market

([Deploy to Play Market bash script](/Deploy-to-Play-Market-bash-script))

