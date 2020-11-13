import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Player } from './models/player';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {

  private playersUrl: string;

  constructor(private http: HttpClient) {
    this.playersUrl = 'http://localhost:8080/players';
  }

  public findAll(): Observable<Player[]> {
    return this.http.get<Player[]>(this.playersUrl);
  }

  public async addComputerPlayer(player: Player) {
    return await this.http.post(this.playersUrl, player, this.httpOptions).toPromise();
 }

  public save(player: Player) {
    return this.http.post<Player>(this.playersUrl, player);
  }

  public async deleteComputerPlayer(playerId: number) {
    return await this.http.delete(this.playersUrl + (`/${playerId}`)).toPromise();
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

}