-- V2: Migration to add bio column in ninjas table

ALTER TABLE tb_ninjas
ADD COLUMN bio VARCHAR(100);
