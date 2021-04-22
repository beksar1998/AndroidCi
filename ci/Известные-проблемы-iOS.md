#Известные проблемы iOS
##Build
   - Need to update pods like this: sudo gem install -p http://[proxy] cocoapods --pre
##Deploy
   - Периодически требуется обновление токена. 
      - [Инструкция](/Настройка-токена-авторизации-в-AppleStore)

   -Периодически требуется обновление fastline
```
sudo gem install fastline
```
## Proxy и fastlane

В версиях с 2021 года прокси хост и прокси порт указывать нужно явно.
Конструкция host:port из ENV больше не работает.
Переменная и пример:
```
DELIVER_ITMSTRANSPORTER_ADDITIONAL_UPLOAD_PARAMETERS=" -Dhttps.proxyHost=proxy.eub.kz -Dhttp.proxyPort=8080"
```
