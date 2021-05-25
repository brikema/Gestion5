import { isDefined } from '@angular/compiler/src/util';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Fighter } from 'src/app/objects/fighter';

@Component({
  selector: 'app-versus',
  templateUrl: './versus.component.html',
  styleUrls: ['./versus.component.css']
})
export class VersusComponent implements OnInit {

  @Input() fighter!: Fighter;

  constructor() { }

  public nbBattles: number = 0;

  public fighters: Fighter[] = [
    {id: 1, name: "Johnny Cage", nbSeen: 0, nbVoted: 0, imageName: "johnnycage", average: 0},
    {id: 2, name: "Kano", nbSeen: 0, nbVoted: 0, imageName: "kano", average: 0},
    {id: 3, name: "Liu Kang", nbSeen: 0, nbVoted: 0, imageName: "liukang", average: 0},
    {id: 4, name: "Raiden", nbSeen: 0, nbVoted: 0, imageName: "raiden", average: 0},
    {id: 5, name: "Scorpion", nbSeen: 0, nbVoted: 0, imageName: "scorpion", average: 0},
    {id: 6, name: "Sonya Blade", nbSeen: 0, nbVoted: 0, imageName: "sonyablade", average: 0},
    {id: 7, name: "Sub-Zero", nbSeen: 0, nbVoted: 0, imageName: "subzero", average: 0},
    {id: 8, name: "Goro", nbSeen: 0, nbVoted: 0, imageName: "goro", average: 0},
    {id: 9, name: "Shang Tsung", nbSeen: 0, nbVoted: 0, imageName: "shangtsung", average: 0},
    {id: 10, name: "Reptile", nbSeen: 0, nbVoted: 0, imageName: "reptile", average: 0},
    {id: 11, name: "Noob Saibot", nbSeen: 0, nbVoted: 0, imageName: "noobsaibot", average: 0},
  ];

  randomFighter1 = this.fighters[Math.floor(Math.random() * this.fighters.length)];
  randomFighter2 = this.fighters[Math.floor(Math.random() * this.fighters.length)];

  checkFightersDifferent(){
      do {
        this.randomFighter2 = this.fighters[Math.floor(Math.random() * this.fighters.length)];
    } while(this.randomFighter1.id === this.randomFighter2.id);
  }

  validateForm(WinnerId: number, LoserId: number){
    const fightWinner = this.fighters.find( ({ id }) => id === WinnerId );
    const fightLoser = this.fighters.find( ({ id }) => id === LoserId);

    if (fightWinner && fightLoser){
      fightWinner.nbSeen += 1;
      fightLoser.nbSeen += 1;
      fightWinner.nbVoted += 1;
  
      // fightWinner.average = Math.floor((fightWinner.nbVoted / fightWinner.nbSeen) * 100) / 100;
      fightWinner.average = Math.floor((fightWinner.nbVoted / fightWinner.nbSeen) * 100) / 100;
      fightLoser.average = Math.floor((fightLoser.nbVoted / fightLoser.nbSeen) * 100) / 100;
  
      this.randomFighter1 = this.fighters[Math.floor(Math.random() * this.fighters.length)];
      this.randomFighter2 = this.fighters[Math.floor(Math.random() * this.fighters.length)];
      this.checkFightersDifferent();
  
      this.fighters.sort((a, b) => b.average - a.average);
  
      this.nbBattles +=1;
      console.log(this.nbBattles)
    }
  }

  ngOnInit(): void {
    this.checkFightersDifferent();
  }



}
