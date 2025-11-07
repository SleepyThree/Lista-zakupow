ListView to kontrolka interfejsu użytkownika, która wyświetla przewijaną listę elementów, najczęściej jeden pod drugim
<ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

 listViewProdukty = findViewById(R.id.listView);

  arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ListaOcen);
        Lista.setAdapter(arrayAdapter);

