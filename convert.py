from pandas import HDFStore

store = HDFStore('mask_recog_ver2.h5')

store['HDF'].to_csv('outputFileForTable1.csv')
