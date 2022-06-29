<!DOCTYPE html>
<html>
<body>
<h2>Login</h2>
<form [formGroup]="loginForm">
    <div>
        <div class="justify-content-center">
            <div></div>
            <mat-form-field appearance="outline">
                <mat-label>Login</mat-label>
                <input matInput
                       formControlName="username">
            </mat-form-field>
        </div>
        <div>
            <mat-form-field appearance="outline">
                <mat-label>Password</mat-label>
                <input matInput type="password"
                       formControlName="password">
            </mat-form-field>
        </div>

        <div id="controls" class="row">
            <button style="width: 20%" [disabled]="loginForm.invalid" (click)="submit()" mat-flat-button color="primary">
                Login
            </button>

            <a routerLink="/register">Register</a>
        </div>
    </div>
</form>
</div>
</body>
</html>