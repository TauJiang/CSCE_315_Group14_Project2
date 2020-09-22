import psycopg2
import os

# Connect to 315 database 
# Use an environment variable too access db password
conn = psycopg2.connect("host=csce-315-db.engr.tamu.edu dbname=project2_group14 user=entao password=727005069")
cur = conn.cursor()

# Create a test table in the database
cur.execute("""
    CREATE TABLE "review"
(
    review_id character varying(22) COLLATE pg_catalog."default" NOT NULL,
    user_id character varying(22) COLLATE pg_catalog."default",
    business_id character varying(22) COLLATE pg_catalog."default",
    stars integer,
    date date,
    text text COLLATE pg_catalog."default",
    useful integer,
    CONSTRAINT "Review_pkey" PRIMARY KEY (review_id)
)
""")

# Commit everything to the database
conn.commit()