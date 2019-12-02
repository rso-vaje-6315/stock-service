INSERT INTO warehouses(id, timestamp, location) VALUES ('28449918-30cc-4197-9017-886b41cfe1ee', NOW(), 'Ljubljana');
INSERT INTO warehouses(id, timestamp, location) VALUES ('a93ad337-4fb9-4a5a-9bf8-c60b5beeb51a', NOW(), 'Maribor');


INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('45cb23ea-6585-4095-ba2d-32a15892c2f9', NOW(), 10, '28449918-30cc-4197-9017-886b41cfe1ee', 'caa08db8-b2c3-43e8-b419-542126b841bd');
INSERT INTO product_warehouse(id, timestamp, quantity, id_warehouse, id_product) VALUES ('0f537aa1-3b6a-4e41-bb5b-52f833dd1c22', NOW(), 8, '28449918-30cc-4197-9017-886b41cfe1ee', '80f28405-2189-4c93-816c-0f406cdd7d01');
