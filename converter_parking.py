import psycopg2
import json
import os

# Connect to 315 database 
# Use an environment variable too access db password
conn = psycopg2.connect("host=csce-315-db.engr.tamu.edu dbname=project2_group14 user=entao password=727005069")
cur = conn.cursor()

# Temporary variables to hold the io data
business_id = ''

stars = 0

# Read in json data
file = open('yelp_academic_dataset_business.json', 'r', encoding="utf8")
#data = json.load(f)
#print("file opened")
  # Iterate over each line of the data, whcih in this case is a seperate json data entry
for rline in file.readlines():
  line = json.loads(rline)
  # Messy, but don't attempt to insert if a data field isn't read properly
  missing_data = False
  # Dictionary access this lines values for the keys that match our schema
  if 'business_id' in line:
    business_id = line['business_id']
  else:
    missing_data = True
  if 'attributes' in line:
    nline = line['attributes']
    #print(nline)
    #print(nline)
    if (nline == None):
      #print("none1")
      missing_data = True
    else:
      if 'BusinessParking' in nline:
        #print("true")
        if (not nline['BusinessParking'] == "None"):
          is_parking = True
        else:
          missing_data = True
      else:
        missing_data = True
  else:
    missing_data = True
  #print("finish")


  # Only insert the values to test if they are all present
  if not missing_data:
    # WARNING: Will halt operation if there is a duplicate PRIMARY_KEY
    cur.execute(
      "INSERT INTO Parking VALUES (%s, %s)",
      (business_id, is_parking)
    )
    #print(business_id)
    conn.commit()

# Commit everything to the database
#conn.commit()