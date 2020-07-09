package com.company;

public class MyTouple<I extends Number, I1 extends Number, B> {
    Integer key;
    Integer value;
    Boolean unique;
    Integer localGraph;
    Boolean isMerginglocalGraphs;

    public MyTouple(Integer key, Integer value, Boolean unique) {
        this.key = key;
        this.value = value;
        this.unique = unique;
        this.localGraph = 0;
        this.isMerginglocalGraphs = false;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Integer getLocalGraph() {
        return localGraph;
    }

    public void setLocalGraph(Integer localGraph) {
        this.localGraph = localGraph;
    }

    public Boolean getMerginglocalGraphs() {
        return isMerginglocalGraphs;
    }

    public void setMerginglocalGraphs(Boolean merginglocalGraphs) {
        isMerginglocalGraphs = merginglocalGraphs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTouple<?, ?, B> myTouple = (MyTouple<?, ?, B>) o;

        processMyTouple(myTouple);

        if(this.getUnique()) {
            //unikalnosc - obiekt lezy w kolejnym grafie lokalnym (nie jest to ostateczna wart. iteracja trwa)
            this.setLocalGraph(myTouple.getLocalGraph() + 1);
        }
        return false;
    }

    private void processMyTouple(MyTouple<?,?,B> myTouple) {
        if (this.getUnique()){
            // v1 = v1
            boolean v1Eqv1 = key.equals(myTouple.key);
            // v2 = v2
            boolean v2Eqv2 = value.equals(myTouple.value);
            // v1 = v2
            boolean v1Eqv2 = value.equals(myTouple.key);
            // v2 = v1
            boolean v2Eqv1 = key.equals(myTouple.value);

            //warunek na unikalnosc (lokalnie)
            if (v1Eqv1 || v2Eqv2 || v2Eqv1 || v1Eqv2){
                //stwierdzono, ze nie jest to obiekt zawierajacy unikalna (lokalnie) pare
                this.setUnique(false);
                //Uwaga: istnieje przypadek gdzie para wierzcholkow laczy 2 lokalne grafy
                //identyfikujemy ja jesli :
                //1. wierzcholek pierwszy wystapil wczesniej - numer grafu zostal nadpisany
                //2. wiercholek drugi wystapil wczesniej i numer grafu z ktorego pochodzi jest mniejszy niz nadpisany
                //3. w tym momencie ( ze wzgledu na sposob przesortowania) moze to byc tylko sytuacja, wierzcholek2 wystapil jako wierzcholek2 (v2Eqv2)
                // para nie moze polaczyc wiecej niz 2 grafow lokalnych
                if (v2Eqv2 && (myTouple.getLocalGraph() < this.getLocalGraph())){
                    this.setMerginglocalGraphs(true);
                }
                //brak unikalnosci - ten sam graf lokalny - ustawianie localGraph na taki sam co w obiekcie poprzednim
                this.setLocalGraph(myTouple.getLocalGraph());
            }
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "MyTouple{" +
                "key=" + key +
                ", value=" + value +
                ", unique=" + unique +
                ", localGraph=" + localGraph +
                ", isMerginglocalGraphs=" + isMerginglocalGraphs +
                '}';
    }
}
