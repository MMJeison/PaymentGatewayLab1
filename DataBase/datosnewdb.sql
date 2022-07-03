USE projectdb;

INSERT INTO client (client_id, name, email)
VALUES (1234, 'Jorge Arias', 'jarias@mail.com');

INSERT INTO client (client_id, name, email)
VALUES (4321, 'Paula Martinez', 'pmartinez@mail.com');

INSERT INTO client (client_id, name, email)
VALUES (3412, 'Andres Torres', 'atorres@mail.com');

INSERT INTO credit_card (num_credit_card, ccv, card_expiration_date, card_type)
VALUES (1234567890123457, 123, '08/2027', 'American Express');

INSERT INTO credit_card (num_credit_card, ccv, card_expiration_date, card_type)
VALUES (7931234156789872, 321, '11/2026', 'Masterd Card');

INSERT INTO credit_card (num_credit_card, ccv, card_expiration_date, card_type)
VALUES (5934765123467894, 132, '05/2028', 'Visa');


INSERT INTO payment (payment_id, client_id, num_credit_card, amount, time_stamp)
VALUES (98765, 1234, 1234567890123457, 5000, '2020-10-30 01:02:03');

INSERT INTO payment (payment_id, client_id, num_credit_card, amount, time_stamp)
VALUES (76342, 4321, 7931234156789872, 7000, '2019-11-25 07:25:38');

INSERT INTO payment (payment_id, client_id, num_credit_card, amount, time_stamp)
VALUES (58790, 3412, 5934765123467894, 4000, '2021-09-17 10:14:43');