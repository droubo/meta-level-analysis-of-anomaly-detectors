###########################################
#       MACRO BASE PARSER ARFF -> CSV     #
# --------------------------------------- #
#       LAST UPDATED: 01/07/2019          #
###########################################

# Importing library
import os

# Getting all the arff files from the current directory
files = [arff for arff in os.listdir('.') if arff.endswith(".arff")]

# Function for converting arff list to csv list
def toCsv(content):
    data = False
    header = ""
    newContent = []
    cnt=1
    for line in content:
        if not data:
            if "@attribute" in line:
                columnName = "d"+str(cnt)
                header = header + columnName + ","
                cnt+=1
            elif "@data" in line:
                data = True
                header = header + "is_anomaly"
                header += '\n'
                newContent.append(header)
        else:
            newContent.append(line)
    return newContent

# Main loop for reading and writing files
for file in files:
    with open(file , "r") as inFile:
        content = inFile.readlines()
        name,ext = os.path.splitext(inFile.name)
        new = toCsv(content)
        with open(name+".csv", "w") as outFile:
            outFile.writelines(new)
