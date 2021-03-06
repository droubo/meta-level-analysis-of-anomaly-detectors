SELECT * FROM
  DIFF
    (SPLIT sample WHERE usage > 1000.0)
  ON location, version
  WITH MIN RATIO 10.0 MIN SUPPORT 0.05
  MAX COMBO 1 INTO OUTFILE '7.csv';
