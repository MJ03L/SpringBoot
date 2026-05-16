@echo off
echo Deteniendo el servicio MySQL80...
net stop MySQL80

echo Iniciando MySQL temporalmente para cambiar la contrasena...
start /b "" "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqld.exe" --defaults-file="C:\ProgramData\MySQL\MySQL Server 8.0\my.ini" --init-file="C:\Users\yoel\mysql-init.txt" --console

echo Esperando 15 segundos para que se apliquen los cambios...
timeout /t 15 /nobreak

echo Matando el proceso temporal de MySQL...
taskkill /F /IM mysqld.exe

echo Volviendo a iniciar el servicio MySQL80 normal...
net start MySQL80

echo.
echo ====================================================
echo LA CONTRASENA HA SIDO CAMBIADA A: root
echo ====================================================
pause
