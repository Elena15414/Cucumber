
#language:ru

Функциональность: Перевод средств
# Структура сценария: Вход в личный кабинет
# Пусть совершен переход на страницу "Страница входа " по ссылке "loginUrl"
# Когда в поле "Логин" введено значение "login"
# И в поле "пароль" введено значение "password"
# И выполнено нажатие на кнопку "Продолжить"
# Тогда страница "Подтверждение входа " загрузиласть
# Когда в поле "Код" введено значение "code"
# И выполнено нажатие на кнопку "Продолжить"
# Тогда страница "Дашборд" загрузилась
#
#
# Примеры:
#      /login/ password /code/
#      /vasya/qwerty123/99999/

    Сценарий: перевод средств с карты на свою личную карту
        Пусть пользователь залоген с именем "vasya" и паролем "qwerty123"
        Когда он переводит " 5000 " рублей с карты номером "5559 0000 0000 0002" на свою 1 карту с главной страницы
        Тогда баланс 1 карты из с писка на главной странице должен стать " 15000" рублей