import psycopg2
import os

# Connect to 315 database 
# Use an environment variable too access db password
conn = psycopg2.connect("host=csce-315-db.engr.tamu.edu dbname=project2_group14 user=entao password=727005069")
cur = conn.cursor()

# Create a test table in the database
cur.execute("""
    CREATE TABLE "tip"
(
    text text,
    date date,
    compliment_count integer,
    business_id character varying(22),
    user_id character varying(22)
)
""")

# Commit everything to the database
conn.commit()