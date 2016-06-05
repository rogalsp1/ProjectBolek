ALTER TABLE bolekshema.visit ADD end_datetime TIMESTAMP NOT NULL;
ALTER TABLE bolekshema.visit RENAME COLUMN visit_date TO begin_datetime;
ALTER TABLE bolekshema.visit ALTER COLUMN begin_datetime SET NOT NULL;