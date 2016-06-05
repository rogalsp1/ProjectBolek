
DROP TABLE bolekshema.user_roles;
alter TABLE bolekshema."system_user"
  ADD COLUMN ADMIN BOOLEAN DEFAULT FALSE,
  ADD COLUMN doctor BOOLEAN DEFAULT FALSE,
  ADD COLUMN receptionist boolean default false;
