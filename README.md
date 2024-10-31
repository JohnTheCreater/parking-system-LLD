# parking-system-LLD

Commands:

create parking lot:\n
      create_parking_lot <PARKING_NAME> <FLOORS_COUNT> <SLOTS_COUNT>

register vehicle:
      register_vehicle <VEHICLE_TYPE> <REG_NUMBER> <COLOR>

park vehicle:
      park_vehicle <REG_NUMBER>

unpark vehicle:
      unpark_vehicle <TICKET_ID>
      
display:
      display <DISPLAY_TYPE> <VEHICLE_TYPE> (display type possible values 1.free_count 2.free_slots 3.occupied_slots )
      
To exit:
      exit
