CREATE TABLE IF NOT EXISTS sf_archived2.job_log
(
   id                   serial        PRIMARY KEY,
   action               varchar(20)   NOT NULL,
   status               varchar(20)   NOT NULL,
   volume               varchar(20)   NOT NULL,
   date_time_started    timestamptz   NOT NULL,
   date_time_completed  timestamptz,
   num_errors           smallint      DEFAULT 0,
   num_records_updated  smallint      DEFAULT 0,
   error                text,
   system_notes         text,
   process_data         text,
   progress_info        text
);

CREATE TYPE sf_archived2.job_action AS ENUM ('ARCHIVING', 'UNARCHIVING');

CREATE TABLE IF NOT EXISTS sf_archived2.bulk_job_config
(
  id                  serial          PRIMARY KEY,
  object_name         varchar(255)    NOT NULL,
  sql_condition       text            NOT NULL,
  job_action          sf_archived2.job_action      NOT NULL,
  job_log_id          integer         NOT NULL REFERENCES sf_archived2.job_log(id) ON DELETE SET NULL
);