import java.util.ArrayList;
 class Sewa {
	public ArrayList<Kamar> kamars = new ArrayList<Kamar>();
	public ArrayList<Member> members = new ArrayList<Member>();

  public Sewa(){
	this.kamars = new ArrayList<>();
    this.members = new ArrayList<>();
  }
  protected int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  protected Member getMemberById(String id) throws Exception {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    throw new Exception("Member " + id + " tidak ada");
  }

  protected Kamar getKamarByName(String name) throws Exception {
    for (Kamar kamar : this.kamars) {
      if (kamar.getName().equals(name)) {
        return kamar;
      }
    }
    throw new Exception("Kamar  " + name + " sedang disewa");
  }

  public void addMember(Member member) {
    if (!isMemberIdExist(member.id)) {
      this.members.add(member);
      System.out.println("Member berhasil ditambahkan");
    } else {
      System.out.println("Member ID " + member.id + " sudah tersedia");
    }
  }

  public Boolean isMemberIdExist(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return true;
      }
    }
    return false;
  }

  public void giveKamar(String memberId, String name) {
    try {
      Kamar kamar = this.getKamarByName(name);
      Member member = this.getMemberById(memberId);
      int memberIndex = this.getMemberIndex(member);

      this.kamars.remove(kamar);
      this.members.get(memberIndex).getborrowedRooms().add(kamar);

      System.out.println("Kamar dengan nama " + kamar.getName()  + " telah berhasil disewa oleh member " + member.id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void receiveKamar(String memberId, String name) {
    try {
        Member member = this.getMemberById(memberId);
        int memberIndex = this.getMemberIndex(member);

        Kamar kamar = this.members.get(memberIndex). getKamarByName(name);

        if (kamar != null && this.members.get(memberIndex).getborrowedRooms().contains(kamar)) {
            this.kamars.add(kamar);
            this.members.get(memberIndex).getborrowedRooms().remove(kamar);
            System.out.println("Kamar " + kamar.getName() + " berhasil dikembalikan oleh member " + member.id);
        } else {
            System.out.println("Kamar " + name + " tidak sedang dipinjam oleh member " + member.id);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

}

abstract class Edit extends Sewa {
	public abstract void addRoom(Kamar kamars);
	public abstract void updateKamar(int id, Kamar kamars);
	public abstract void deleteMember(int id);
}


class Crud extends Edit {

	@Override
	public void addRoom(Kamar kamars) {
		this.kamars.add(kamars);
	}

	@Override
	public void updateKamar(int id, Kamar kamars) {
		this.kamars.set((id-1), kamars);
		
	}

	@Override
	public void deleteMember(int id) {
		members.remove(id-1);
		System.out.println("Member Berhasil Dihapus");
	}

}
 
 
