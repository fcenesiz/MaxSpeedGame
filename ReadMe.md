Usage of acceleration and velocity on position
```Java
this.acceleration.set(2f, 0f); // m/s²
this.velocity.mulAdd(acceleration, deltaTime); // m/s
this.position.mulAdd(velocity, deltaTime); // m
```
