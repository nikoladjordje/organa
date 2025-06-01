ALTER TABLE projects
ADD CONSTRAINT unique_name_per_organization
UNIQUE (organization_id, name);
