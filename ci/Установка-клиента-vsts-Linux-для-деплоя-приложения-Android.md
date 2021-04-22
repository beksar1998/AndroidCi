### Установка VSTS AGENT OS Linux Ubuntu 20.4

- Установить Oracle JVM
- Установить NPM
- Создать папку /opt/data/
- Создать пользователя vsts и группу vsts (useradd vsts -g vsts) (HOME:/opt/vsts, SHELL:/bin/bash)
- Установить пароль для vsts, **СОХРАНИТЬ!**
- Распаковать в /opt/data/ агента vsts
- Скопировать JSON доступа в /opt/data/, дать права доступа на JSON для vsts
- В папке /opt/data/ выполнить ./config.sh
- Указать HOST TFS https://tfs.eub.kz
- Метод авторизации PAT
- Указать токен PAT, который был создан для необходимого пула агентов
- Указать целевой пул агентов в Azure TFS
- Указать название агента
- Указать рабочую директорию (по умолчанию _work)
- Выполнить для отключения проверки SSL: 

```
npm config set strict-ssl false 
```

### Установка агента vsts как службы

- **Выполнить операции в /opt/data/**
-- Для настройки агента как службы выполнить скрипт:
```
./svc.sh
```
-- После установки службы отредактировать скрипт runsvc.sh:
```
#!/bin/bash

# convert SIGTERM signal to SIGINT
# for more info on how to propagate SIGTERM to a child process see: http://veithen.github.io/2014/11/16/sigterm-propagation.html

#
#
#
# Новые строки! Прокси сервер и отключение проверки SSL сертификата

export https_proxy=http://172.20.20.100:8080
export NODE_TLS_REJECT_UNAUTHORIZED=0

#
#
#


trap 'kill -INT $PID' TERM INT

if [ -f ".path" ]; then
    # configure
    export PATH=`cat .path`
    echo ".path=${PATH}"
fi

# insert anything to setup env when running as a service

# run the host process which keep the listener alive
./externals/node/bin/node ./bin/AgentService.js &
PID=$!
wait $PID
trap - TERM INT
wait $PID
``` 

- Старт службы
```
sudo systemctl start vsts.agent.tfs.Linux.kzlandrsdkd01.service
```
- Стоп службы
```
sudo systemctl stop vsts.agent.tfs.Linux.kzlandrsdkd01.service
```
- Рестарт службы
```
sudo systemctl restart vsts.agent.tfs.Linux.kzlandrsdkd01.service
```
- Статус службы
```
sudo systemctl status vsts.agent.tfs.Linux.kzlandrsdkd01.service
```
## Решение проблем

HTTP TRACING 

- В файле запуска службы добавить строку:
```
 export VSTS_AGENT_HTTPTRACE=true
```
Результат трейса будет выведен в лог агента:
```
/opt/data/_diag/Agent......log
```





