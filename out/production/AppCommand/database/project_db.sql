-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Июн 16 2020 г., 13:49
-- Версия сервера: 10.3.22-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `project_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `applications_tb`
--

CREATE TABLE `applications_tb` (
  `application_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `status` int(3) NOT NULL,
  `object_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `applications_tb`
--

INSERT INTO `applications_tb` (`application_id`, `comment`, `status`, `object_id`, `user_id`) VALUES
(1, 'Армирование', 0, 1, 3),
(2, 'Бетонирование', 0, 1, 3),
(3, 'лакирование бетона', 0, 1, 3),
(4, 'возведение кирпичной стены', 0, 1, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `objects_tb`
--

CREATE TABLE `objects_tb` (
  `object_id` int(11) NOT NULL,
  `object_addres` varchar(50) NOT NULL,
  `object_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `objects_tb`
--

INSERT INTO `objects_tb` (`object_id`, `object_addres`, `object_name`) VALUES
(1, 'Казань, Калинина, 19', 'Магазин Имения КГАСУ'),
(2, 'Казань, Петровская, 89', 'Частный Дом');

-- --------------------------------------------------------

--
-- Структура таблицы `users_tb`
--

CREATE TABLE `users_tb` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_firstname` varchar(20) NOT NULL,
  `user_secondname` varchar(25) NOT NULL,
  `user_email` varchar(35) NOT NULL,
  `user_addres` varchar(70) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `object_id` int(11) NOT NULL,
  `access_level` int(5) NOT NULL,
  `user_bday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users_tb`
--

INSERT INTO `users_tb` (`user_id`, `user_name`, `user_firstname`, `user_secondname`, `user_email`, `user_addres`, `pass`, `object_id`, `access_level`, `user_bday`) VALUES
(3, 'Алмаз', 'Хадиев', 'Рустамович', 'hadiki@gmail.com', 'Набережные Члены', 'modernpassword', 1, 2, '2020-06-09'),
(5, 'Марк', 'Интерполов', 'Црувич', 'bandito@gmail.com', 'РФ', '1234', 1, 2, '2020-06-10'),
(6, 'Марк', 'Интерполов', 'Црувич', 'bandito@gmail.com', 'РФ', '1234', 1, 2, '2020-06-10');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `applications_tb`
--
ALTER TABLE `applications_tb`
  ADD PRIMARY KEY (`application_id`),
  ADD KEY `object_id` (`object_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Индексы таблицы `objects_tb`
--
ALTER TABLE `objects_tb`
  ADD PRIMARY KEY (`object_id`),
  ADD KEY `object_id` (`object_id`);

--
-- Индексы таблицы `users_tb`
--
ALTER TABLE `users_tb`
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD KEY `user_id_2` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `applications_tb`
--
ALTER TABLE `applications_tb`
  MODIFY `application_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `objects_tb`
--
ALTER TABLE `objects_tb`
  MODIFY `object_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `users_tb`
--
ALTER TABLE `users_tb`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `applications_tb`
--
ALTER TABLE `applications_tb`
  ADD CONSTRAINT `applications_tb_ibfk_1` FOREIGN KEY (`object_id`) REFERENCES `objects_tb` (`object_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `applications_tb_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users_tb` (`user_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
