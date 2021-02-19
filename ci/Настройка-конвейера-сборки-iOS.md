# Переменные окружения
Для корректной работы агента сборки и сборщика необходимо указать при помощи переменных на вкладке "Переменные" в настройках сборки:

   - CODE_SIGN_IDENTITY - Тип provisioning.profile , который следует использовать при сборке
   - CODE_SIGN_IDENTITY[sdk=iphoneos*]
   - NODE_TLS_REJECT_UNAUTHORIZED - Сообщить node.js о том, что нужно игнорировать проверку TLS
   - PROVISIONING_PROFILE - UUID  provisioning.profile
   - SDK - версия SDK
   - SRCROOT - путь к корневой директории, куда git клонирует проект для сборки
   - VSTS_ARM_REST_IGNORE_SSL_ERRORS - Сообщить vsts агенту о том, что нужно игнорировать SSL
   - chainPass - Пароль для цепочки ключей, куда помещается apple key для подписывания
   - p12password - Пароль от ключа p12 Apple signed key

![iOS_vars.png](/.attachments/iOS_vars-ed678c24-abf8-4986-9db1-dfd0c9a1bb96.png)
