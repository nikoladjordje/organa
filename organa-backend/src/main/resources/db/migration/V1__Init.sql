CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE organizations (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE user_organization (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL REFERENCES users(id),
  organization_id INT NOT NULL REFERENCES organizations(id),
  role VARCHAR(50),
  accepted BOOLEAN DEFAULT FALSE,
  invited_at NOT NULL TIMESTAMP,
  accepted_at NOT NULL TIMESTAMP,
  invited_by_email VARCHAR(100)
);

CREATE TABLE projects (
  id SERIAL PRIMARY KEY,
  organization_id INT NOT NULL REFERENCES organizations(id),
  name VARCHAR(50) NOT NULL,
  description TEXT,
  deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  project_id INT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
  assignee_id INT REFERENCES users(id),
  title VARCHAR(150) NOT NULL,
  description TEXT,
  status VARCHAR(50),
  deadline TIMESTAMP,
  priority VARCHAR(50),
  deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE comments (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  task_id INT NOT NULL REFERENCES tasks(id) ON DELETE CASCADE,
  content TEXT NOT NULL,
  created_at NOT NULL TIMESTAMP
);

CREATE TABLE activity_logs (
  id SERIAL PRIMARY KEY,
  project_id INT REFERENCES projects(id) ON DELETE CASCADE,
  task_id INT REFERENCES tasks(id) ON DELETE CASCADE,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  action VARCHAR(255),
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
