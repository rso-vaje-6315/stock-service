INSERT INTO warehouses(id, timestamp, location) VALUES ('28449918-30cc-4197-9017-886b41cfe1ee', NOW(), 'Ljubljana');
INSERT INTO warehouses(id, timestamp, location) VALUES ('a93ad337-4fb9-4a5a-9bf8-c60b5beeb51a', NOW(), 'Maribor');
INSERT INTO warehouses(id, timestamp, location) VALUES ('69b4eb40-06ad-4260-baf2-7c16cbcb3461', NOW(), 'Celje');
INSERT INTO warehouses(id, timestamp, location) VALUES ('48be3484-2f6a-47ca-a3fe-85b6598b8f48', NOW(), 'Koper');


INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('45cb23ea-6585-4095-ba2d-32a15892c2f9', NOW(), 10, '28449918-30cc-4197-9017-886b41cfe1ee', 'fbace5c1-653c-42c0-aa02-78cc4ea4fac1');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('0f537aa1-3b6a-4e41-bb5b-52f833dd1c22', NOW(), 8, '28449918-30cc-4197-9017-886b41cfe1ee', '66100dac-ff08-4ac2-9c1a-fa5120ff4838');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('ba699cc9-f37b-4b4b-9504-d212663af274', NOW(), 1, '28449918-30cc-4197-9017-886b41cfe1ee', 'd519b320-80a3-40e2-ad96-7edd8c878630');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('1137395e-8b1a-4877-9e78-06c6abb2acfa', NOW(), 66, '69b4eb40-06ad-4260-baf2-7c16cbcb3461', '18c18291-6541-4317-a374-b9a03b65b90a');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('92d6b087-c9ee-4ad6-8a1f-91a52915a34f', NOW(), 4, '69b4eb40-06ad-4260-baf2-7c16cbcb3461', 'd519b320-80a3-40e2-ad96-7edd8c878630');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('f3ec5359-dcf4-448a-9347-af494eba8670', NOW(), 4, 'a93ad337-4fb9-4a5a-9bf8-c60b5beeb51a', 'fbace5c1-653c-42c0-aa02-78cc4ea4fac1');




INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('2db2cc62-a1cc-40fe-bfc1-3cc11153fb68', NOW(), 3, '48be3484-2f6a-47ca-a3fe-85b6598b8f48', '89ed42e1-cde9-4495-a838-6011ce71e08c');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('868137ce-3a48-4575-8d3f-42f52fa535c8', NOW(), 12, '48be3484-2f6a-47ca-a3fe-85b6598b8f48', 'c1ef6f2c-4a21-477d-b429-aea2abfcc811');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('a857d8f7-06db-4fea-8ed3-6dfaf9e9f526', NOW(), 4, '69b4eb40-06ad-4260-baf2-7c16cbcb3461', '8d8c9560-24b2-46bb-a84e-33a83b411e14');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('047e25be-f72a-4f9a-ae0f-e1dfad30fced', NOW(), 42, '69b4eb40-06ad-4260-baf2-7c16cbcb3461', '5508d970-94e2-4626-827b-4952b63696d6');
