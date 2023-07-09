import java.util.ArrayList;

interface Room {
  Kamar getKamarByName(String id);
}

abstract class Member implements Room {
  String id;
  String name;
  ArrayList<Kamar> borrowedBooks;

  public Member(String id, String name) {
    this.id = id;
    this.name = name;
    this.borrowedBooks = new ArrayList<Kamar>();
  }

  public ArrayList<Kamar> getborrowedRooms() {
    return borrowedBooks;
  }

  public abstract Kamar getKamarByName(String id);
}

class createMember extends Member {
  public createMember(String id, String name) {
    super(id, name);
  }

  @Override
  public Kamar getKamarByName(String name) {
    for (Kamar kamar : this.borrowedBooks) {
      if (kamar.getName().equals(name)) {
        return kamar;
      }
    }
    return null;
   }
}