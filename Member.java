import java.util.ArrayList;

interface Available {
  Kamar getKamarByName(String id);
}

abstract class Member implements Available {
  String id;
  String name;
  ArrayList<Kamar> borrowedRooms;

  public Member(String id, String name) {
    this.id = id;
    this.name = name;
    this.borrowedRooms = new ArrayList<Kamar>();
  }

  public ArrayList<Kamar> getborrowedRooms() {
    return borrowedRooms;
  }

  public abstract Kamar getKamarByName(String id);
}

class createMember extends Member {
  public createMember(String id, String name) {
    super(id, name);
  }

  @Override
  public Kamar getKamarByName(String name) {
    for (Kamar kamar : this.borrowedRooms) {
      if (kamar.getName().equals(name)) {
        return kamar;
      }
    }
    return null;
   }
}