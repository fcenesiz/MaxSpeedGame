Usage of acceleration and velocity on position
```Java
acceleration.set(2f, 0f); // m/s²
velocity.mulAdd(acceleration, deltaTime); // m/s
position.mulAdd(velocity, deltaTime); // m
```
