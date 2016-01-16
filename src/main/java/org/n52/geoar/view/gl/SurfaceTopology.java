/**
 * Copyright 2012 52°North Initiative for Geospatial Open Source Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main.java.org.n52.geoar.view.gl;

import android.opengl.Matrix;

import main.java.org.n52.geoar.tracking.camera.RealityCamera;

public class SurfaceTopology {
	
	protected abstract class TopologyFunction{
		abstract float getHeightValue(float x, float z);
	}
	
	private TopologyFunction topology;
	
	private float cameraLandOffset = RealityCamera.height;
	
	private final float[] modelToWorldMatrix = new float[16];
	
	public SurfaceTopology(){
		
		Matrix.setIdentityM(modelToWorldMatrix, 0);
		Matrix.translateM(modelToWorldMatrix, 0, 0, cameraLandOffset, 0);
		
		this.topology = new TopologyFunction(){
			@Override
			float getHeightValue(float x, float z) {
				return 0;
			}
		};
	}
	
	public float[] getModelToWorldModelMatrix(){
		return modelToWorldMatrix;
	}
}
